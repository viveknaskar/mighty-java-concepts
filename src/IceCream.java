import java.io.OutputStreamWriter;

public class IceCream {
    public static void main(String[] args) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(System.out, "UTF-16");
            String sb = "				WWW\n"
                    + "			  WWWWW\n"
                    + "			WWWWWWW\n"
                    + "		   WWWWWWWW\n"
                    + "		 WWWWWWWWWW\n"
                    + "	   BBBBWWWWRRRR\n"
                    + "	BBBBBBBWRRRRRR\n"
                    + "  BBBBBBBBBRRRRRRR\n"
                    + " BBBBBBBBBBRRRRRRR\n"
                    + " BBBBBBBBBBRRRRRRR\n"
                    + "  BBBBBBBBBRRRRRRR\n"
                    + "   BBBBBBBOORRRRRR\n"
                    + "	 OOOOOOOOORRRR\n"
                    + "	 OOOOOOOOOOOR\n"
                    + "	 OOOOOOOOOO\n"
                    + "	 OOOOOOOOO\n"
                    + "	 OOOOOOOO\n"
                    + "	 OOOOOOO\n"
                    + "	 OOOOOO\n"
                    + "	 OOOOO\n"
                    + "	 OOOO\n"
                    + "	 OOO\n"
                    + "	 OO\n"
                    + "	 O";
            osw.write(sb.replaceAll("B", "\uD83D\uDD35").replaceAll("R", "\uD83D\uDD34").replaceAll("W", "\u26AA").replaceAll("O", "\uD83D\uDD36"));
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
