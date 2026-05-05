


import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.imageio.ImageIO;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.util.Duration;
/**
 *
 * @author Eudy Contreras
 *
 * This program records a javaFX scene by taking continuous snapshots of the scene
 * which are than stored and saved to a predefined destination. The program allows the
 * user to save and retrieve the frame based videos make by this program which can
 * then be play on a specified layer or "screen".
 *
 */
public class SceneCaptureUtility {

	private int frame = 0; // The current frame which is being displayed
	private int timer = 0; // recording timer.
	private int record_time; // Amount of time the recorder will record
	private int counter = 0;
	
	private float frameRate = 15.0f; 
	
	private long capture_rate = (long) (1000f / frameRate); // Rate at which the recorder will recored. Default rate: 60FPS

	private PlaybackSettings playSettings;
	
	private Double frameCap = 1.0 / frameRate; // FrameRate at which the recorded video will play
	private Double video_size_scale = 1.0; // Scale of the video relative to its size: 0.5 = half, 2.0 = double the size
	private Double bounds_scale_X = 0.5; // Scale factor for scaling relative to assigned or obtained resolution
	private Double bounds_scale_Y = 0.5;

	private Boolean saveFrames = false; //If true saves the individual frames of the video as images
	private Boolean loadFrames = false; //If true allows retrieving previously saved frames for playBack
	private Boolean allowRecording = false;
	private Boolean allowPlayback = false;
	private Boolean showIndicators = false;

	private Pane indicator_layer;
	private Pane video_screen;

	private Scene scene;

	private Timeline videoPlayer;

	private List<Image> recorded_frames; //Stores recorded frames
	private List<ImageView> video_frames; //Stores frames for playBack
	private List<byte[]> temp_frames; //Stores frames for saving

	private final SnapshotParameters parameters = new SnapshotParameters();

	private final ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();

	private final Indicator recording = new Indicator(Color.RED, " Recording..");
	private final Indicator playing = new Indicator(Color.GREEN, " Playing..");
	private final Indicator idle = new Indicator(Color.YELLOW, "paused..");

	private final String VIDEO_NAME = "recording2.FXVideo";
	private final String FRAME_NAME = "image";
	private final String DIRECTORY_NAME = "Snake Game Videos"+ File.separator;
	private final String PATH_ROOT = System.getProperty("user.home") + "/Desktop" + File.separator +DIRECTORY_NAME;
	private final String FILE_EXTENSION = "jpg";
	private final String PATH_FRAME = PATH_ROOT + FRAME_NAME;
	private final String PATH_VIDEO = PATH_ROOT + VIDEO_NAME;

	/**
	 * Constructs a scene capture utility with a default scene, a pane which 
	 * will be used to display the state indicators, the amount of time which
	 * the recorder will be running and a condition to whether or not the indicators
	 * will be shown.
	 * @param scene: scene which will be recored.
	 * @param indicatorLayer: layer which will be used to show the state indicators.
	 * @param record_time: time in minutes for which the recorder will be recording
	 * @param showIndicators: condition which determines if the indicators will be shown.
	 */
	public SceneCaptureUtility(Scene scene, Pane indicatorLayer, int record_time, boolean showIndicators) {
		this.scene = scene;
		this.showIndicators = showIndicators;
		this.record_time = record_time * 60;
		this.initStorages(indicatorLayer);
		this.loadRecording();
		this.scaleResolution(0, 0, false);
	}
	/*
	 * Initializes the list used to store the captured frames.
	 */
	private void initStorages(Pane layer) {
		if(showIndicators)
			this.indicator_layer = layer;
		video_frames = new LinkedList<ImageView>();
		recorded_frames = new LinkedList<Image>();
		temp_frames = new LinkedList<byte[]>();
	}
	public void addFrame(Image... frame) {
		if (frame.length > 1) {
			recorded_frames.addAll(Arrays.asList(frame));
		} else {
			recorded_frames.add(frame[0]);
		}
	}
	/**
	 * loads recordings and or frames from a specified location
	 */
	private void loadRecording(){
		if (loadFrames) {
			loadFromFile();
		} else {
			retrieveRecording();
		}
	}
	/*
	 * Resets the list
	 */
	private void resetStorage() {
		if (video_frames != null)
			video_frames.clear();
		if (recorded_frames != null)
			recorded_frames.clear();
		if (video_screen != null)
			video_screen.getChildren().clear();
	}
	/**
	 * Method which when called will start recording the given scene.
	 */
	public void startRecorder() {
		if (!allowRecording) {
			resetStorage();
			if(showIndicators)
			showIndicator(indicator_layer.getChildren(), recording);
			videoRecorder();
			allowRecording(true);
			logState("Recording...");
		}
	}
	/**
	 * Method which when called will stop the recording
	 */
	public void stopRecorder() {
		if (allowRecording) {
			if(showIndicators)
			showIndicator(indicator_layer.getChildren(), idle);
			allowRecording(false);
			logState("Recording stopped");
			logState("Amount of recorded frames: " + recorded_frames.size());
			processVideo();
			saveVideo();
		}
	}
	/**
	 * Method which when called will start playBack of the recorded video onto
	 * a given screen or layer.
	 * @param output_screen: layer used to display the video
	 * @param settings: video settings that determine the playBack conditions.
	 */
	public void starPlayer(Pane output_screen, PlaybackSettings settings) {
		video_screen = output_screen;
		playSettings = settings;
		if(showIndicators)
		showIndicator(indicator_layer.getChildren(), playing);
		if (video_frames.size() > 0) {
			logState("Video playback..");
			resetPlayback();
			if (videoPlayer == null)
				videoPlayer();
			else {
				videoPlayer.play();
			}
			allowPlayback(true);
		}
		else{
			logState("Nothing to play!");
		}

	}
	/**
	 * Method which when called will stop the playBack of the video
	 */
	public void stopPlayer() {
		if(showIndicators)
		showIndicator(indicator_layer.getChildren(), idle);
		if (videoPlayer != null)
			videoPlayer.stop();
		logState("Playback stopped");
		allowPlayback(false);
	}
	/*
	 * Method which creates a task which records the video at
	 * a specified rate for a specified time 
	 */
	private void videoRecorder() {
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				while (true) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							if (allowRecording && record_time > 0) {
//								recorded_frames.add();
								addFrame(create_frame());
								
							}

							recordingTimer();
						}
					});
					Thread.sleep(capture_rate);
				}
			}
		};
		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}
	/*
	 * Method which creates a timeLine which plays the video 
	 * at a specified frameRate onto a given screen or layer.
	 */
	private void videoPlayer() {

		videoPlayer = new Timeline();
		videoPlayer.setCycleCount(Animation.INDEFINITE);

		KeyFrame keyFrame = new KeyFrame(Duration.seconds(frameCap), 

				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {

						if (allowPlayback) {

							playbackVideo();

						}
					}
				});

		videoPlayer.getKeyFrames().add(keyFrame);
		videoPlayer.play();

	}
	/**
	 * Calls to this method will decreased the time left on the 
	 * recording every second until the recording time reaches
	 * zero. this will cause the recording to stop.
	 */
	private void recordingTimer() {
		timer++;
		if (allowRecording && timer >= frameRate) {
			record_time -= 1;
			timer = 0;
			if (record_time <= 0) {
				record_time = 0;
			}
		}
	}
	/**
	 * A call to this method will add the recorded frames to the video list 
	 * making them reading for playBack.
	 */
	private void processVideo() {
		logState("Processing video...");
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				for (int i = 0; i < recorded_frames.size(); i++) {
					video_frames.add(new ImageView(recorded_frames.get(i)));
				}
				logState("Video has been processed.");
				return null;
			}
		};
		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}
	/**
	 * Call to this method will play the video on the given screen
	 * adding a removing frames.
	 * @return: screen in which the frames are being rendered
	 */
	private final Pane playbackVideo() {
		if (video_screen.getChildren().size() > 0)
			video_screen.getChildren().remove(0);
		video_screen.getChildren().add(video_frames.get(frame));
		frame += 1;
		if (frame > video_frames.size() - 1) {
			if(playSettings == PlaybackSettings.CONTINUOUS_REPLAY){
				frame = 0;
			}
			else if(playSettings == PlaybackSettings.PLAY_ONCE){
				frame = video_frames.size() - 1;
				allowPlayback = false;
			}
		}
		return video_screen;
	}

	public void setVideoScale(double scale) {
		this.video_size_scale = scale;
	}
	/**
	 * A called to this method will scale the video
	 * to a given scale.
	 * @param scale: new scale of the video. 1.0 is normal
	 * 0.5 is half and 2.0 is twice the size.
	 */
	public void scaleVideo(double scale) {
		this.video_size_scale = scale;
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				if (video_frames.size() > 0) {
					logState("Scaling video...");
					for (int i = 0; i < video_frames.size(); i++) {
						video_frames.get(i).setFitWidth(video_frames.get(i).getImage().getWidth() * video_size_scale);
						video_frames.get(i).setFitHeight(video_frames.get(i).getImage().getHeight() * video_size_scale);
					}
					logState("Video has been scaled!");
				}
				return null;
			}
		};
		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}
	/**
	 * A called to this method will attempt to prepare the video and or frames
	 * for saving
	 */
	private void saveVideo() {
		File root = new File(PATH_ROOT);
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				root.mkdirs();
				for (int i = 0; i < recorded_frames.size(); i++) {
					saveToFile(recorded_frames.get(i));
				}
				saveRecording(temp_frames);
				logState("Amount of compiled frames: " + temp_frames.size());
				return null;
			}
		};
		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}
	/**
	 * A called to this method will add the frames store is array list 
	 * to the video list.
	 * @param list: list containing the byte arrays of the frames
	 */
	private void loadFrames(List<byte[]> list) {
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				logState("loading frames...");
				for (int i = 0; i < list.size(); i++) {
					video_frames.add(byteToImage(list.get(i)));
				}
				logState("frames have been added!");
				scaleVideo(video_size_scale);
				return null;
			}
		};
		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}
	/**
	 * Method which when called will add and display a indicator.
	 * @param rootPane: list to which the indicator will be added
	 * @param indicator: indicator to be displayed
	 */
	private void showIndicator(ObservableList<Node> rootPane, Indicator indicator) {
		rootPane.removeAll(playing, idle, recording);
		indicator.setTranslateX(scene.getWidth() - ScaleX(150));
		indicator.setTranslateY(ScaleY(100));
		rootPane.add(indicator);
	}
	/**
	 * Calls to this method will save each frame if conditions are met
	 * and will also store each frame into a list of byte arrays.
	 * @param image: image to be saved to file and or converted and store as
	 * a byte array.
	 */
	private void saveToFile(Image image) {
		counter += 1;
		BufferedImage BImage = SwingFXUtils.fromFXImage(image, null);
		temp_frames.add(ImageToByte(BImage));
		if (saveFrames) {
			File video = new File(PATH_FRAME + counter + "." + FILE_EXTENSION);
			try {
				ImageIO.write(BImage, FILE_EXTENSION, video);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	/**
	 * Method which when called loads images from a predefined 
	 * directory in order to play them as a video.
	 */
	private void loadFromFile() {
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				for (int i = 1; i < 513; i++) {
					File video = new File(PATH_FRAME + i + "." + FILE_EXTENSION);
					video_frames.add(new ImageView(new Image(video.toURI().toString())));
				}
				return null;
			}
		};
		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}
	/**
	 * Method which when called will attempt to save the video 
	 * to a specified directory.
	 * @param list
	 */
	private void saveRecording(List<byte[]> list) {
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				File root = new File(PATH_ROOT);
				File video = new File(PATH_VIDEO);
				video.delete();
				logState("Saving video...");
				try {
					root.mkdirs();
					FileOutputStream fileOut = new FileOutputStream(PATH_VIDEO);
					BufferedOutputStream bufferedStream = new BufferedOutputStream(fileOut);
					ObjectOutputStream outputStream = new ObjectOutputStream(bufferedStream);
					outputStream.writeObject(list);
					outputStream.close();
					fileOut.close();
					logState("Video saved.");

				} catch (IOException e) {
					logState("Failed to save, I/O exception");
					e.printStackTrace();
				}
				return null;
			}
		};

		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}
	/**
	 * Method which when called attempts to retrieve the video
	 * from a specified directory
	 */
	@SuppressWarnings("unchecked")
	private void retrieveRecording() {
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				File root = new File(PATH_ROOT);
				File video = new File(PATH_VIDEO);

				if (root.exists() && video.exists()) {
					try {
						FileInputStream fileIn = new FileInputStream(PATH_VIDEO);
						ObjectInputStream inputStream = new ObjectInputStream(fileIn);
						temp_frames = (ArrayList<byte[]>) inputStream.readObject();
						inputStream.close();
						fileIn.close();
						logState("\nLoading video");
						loadFrames(temp_frames);
					} catch (IOException | ClassNotFoundException e) {
						logState("Failed to load! " + e.getLocalizedMessage());
					}
				} else {
					logState("Nothing to load.");
				}
				return null;
			}
		};

		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();

	}
	
	/**
	 * Method which when call creates a frame or snapshot of the 
	 * given scene to be recorded.
	 * @return: frame taken from the scene.
	 */

	private synchronized Image create_frame() {
		WritableImage sceneShot = scene.snapshot(null);
		return sceneShot;
	}
	/**
	 * Method which when called crates a frame or snapshot of the 
	 * given node.
	 * @param node: node to be recorded
	 * @return: image or frame of recorded node.
	 */
	@SuppressWarnings("unused")
	private synchronized Image create_node_frame(Node node) {
		parameters.setFill(Color.TRANSPARENT);
		WritableImage wi = new WritableImage((int)node.getBoundsInLocal().getWidth(), (int) node.getBoundsInLocal().getHeight());
		node.snapshot(parameters, wi);
		return wi;

	}
	/**
	 * Method which when called will create a scale relative to a base
	 * and current resolution.
	 * @param scaleX: x scaling factor used for manual scaling
	 * @param scaleY: y scaling factor used for manual scaling
	 * @param manualScaling: determines if a manual scaling will be applied or not
	 */
	public void scaleResolution(double scaleX, double scaleY, boolean manualScaling) {
		double resolutionX = Screen.getPrimary().getBounds().getWidth();
		double resolutionY = Screen.getPrimary().getBounds().getHeight();
		double baseResolutionX = 1920;
		double baseResolutionY = 1080;
		bounds_scale_X = baseResolutionX / resolutionX;
		bounds_scale_Y = baseResolutionY / resolutionY;
		if(manualScaling==true){
			bounds_scale_X = bounds_scale_X*scaleX;
			bounds_scale_Y = bounds_scale_Y*scaleY;
		}
	}

	public void allowRecording(boolean state) {
		allowRecording = state;
		logState("allowed recording: " + state);
	}

	public void allowPlayback(boolean state) {
		allowPlayback = state;
		logState("allowed playback: " + state);
	}

	public void setLocation(double x, double y) {
		video_screen.setTranslateX(x);
		video_screen.setTranslateY(y);
	}
	public void setDimensions(double width, double height) {
		video_screen.setPrefSize(width, height);;
	}
	public void resetPlayback() {
		this.frame = 0;
	}

	public double Scale(double value) {
		double newSize = value * (bounds_scale_X + bounds_scale_Y)/2;
		return newSize;
	}

	public double ScaleX(double value) {
		double newSize = value * bounds_scale_X;
		return newSize;
	}

	public double ScaleY(double value) {
		double newSize = value * bounds_scale_Y;
		return newSize;
	}

	public double getVideoWidth(){
		if(!video_frames.isEmpty())
			return video_frames.get(0).getImage().getWidth() * video_size_scale;
		else{
			return 0;
		}
	}
	public double getVideoHeight(){
		if(!video_frames.isEmpty())
		return video_frames.get(0).getImage().getWidth() * video_size_scale;
		else{
			return 0;
		}
	}
	@SuppressWarnings("unused")
	private String loadResource(String image) {
		String url = PATH_ROOT + image;
		return url;
	}
	/**
	 * Method which converts a bufferedimage to byte array
	 * @param image: image to be converted
	 * @return: byte array of the image
	 */
	public final byte[] ImageToByte(BufferedImage image) {

		byte[] imageInByte = null;
		try {
			if (image != null) {
				ImageIO.write(image, FILE_EXTENSION, byteOutput);
				imageInByte = byteOutput.toByteArray();
				byteOutput.flush();
			}
		} catch (IOException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		try {
			return imageInByte;
		} finally {
			byteOutput.reset();
		}
	}
	/**
	 * Method which converts a byte array to a ImageView
	 * @param data: byte array to be converted.
	 * @return: imageView of the byte array
	 */
	public final ImageView byteToImage(byte[] data) {
		BufferedImage newImage = null;
		ImageView imageView = null;
		Image image = null;
		try {
			InputStream inputStream = new ByteArrayInputStream(data);
			newImage = ImageIO.read(inputStream);
			inputStream.close();
			image = SwingFXUtils.toFXImage(newImage, null);
			imageView = new ImageView(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageView;
	}

	private void logState(String state) {
		System.out.println("JAVA_FX SCREEN RECORDER: " + state);
	}

	public enum PlaybackSettings {
		CONTINUOUS_REPLAY, PLAY_ONCE,
	}
	
	/**
	 * Class which crates a simple indicator which can be 
	 * used to display a recording or playing state
	 * @author Eudy Contreras
	 *
	 */
	private class Indicator extends HBox {
		public Indicator(Color color, String message) {
			Circle indicator = new Circle(Scale(15), color);
			Text label = new Text(message);
			label.setFont(Font.font("", FontWeight.EXTRA_BOLD, Scale(20)));
			label.setFill(Color.WHITE);
			setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
			getChildren().addAll(indicator, label);
		}
	}
}
