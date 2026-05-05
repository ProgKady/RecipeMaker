package kadysoft.kady;
public class BannerPrinter {
    public static void main(String[] args) {
        String banner = 
            "\033[38;5;39m╔═╗┌─┐┌─┐┌┬┐┌─┐┬  ┌─┐┬┌┬┐┌─┐\n" +
            "\033[38;5;44m╚═╗├┤ ├┤  │ ├─┤│  ├┤ │ │ ├┤ \n" +
            "\033[38;5;45m╚═╝└  └─┘ ┴ ┴ ┴┴─┘└─┘┴ ┴ └─┘\n" +
            "\033[0m";
        System.out.println(banner);
    }
}
