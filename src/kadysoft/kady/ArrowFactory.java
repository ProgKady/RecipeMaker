package kadysoft.kady;

import java.util.function.Function;
import java.util.function.IntFunction;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import org.reactfx.value.Val;

public class ArrowFactory implements IntFunction {
   private final ObservableValue shownLine;

   ArrowFactory(ObservableValue shownLine) {
      this.shownLine = shownLine;
   }

   public Node apply(int lineNumber) {
      Polygon triangle = new Polygon(new double[]{0.0D, 0.0D, 10.0D, 5.0D, 0.0D, 10.0D});
      triangle.setFill(Color.GREEN);
      ObservableValue visible = Val.map(this.shownLine, (sl) -> {
         return sl.hashCode() == lineNumber;
      });
      triangle.visibleProperty().bind(Val.flatMap(triangle.sceneProperty(), (scene) -> {
         return (ObservableValue)(scene != null ? visible : Val.constant(false));
      }));
      return triangle;
   }
}

