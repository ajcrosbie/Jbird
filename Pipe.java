public class Pipe {
    int width = 100;
    int height;
    int startH;
    int startW;

    Pipe(int heightTemp, int startHTemp, int startWTemp) {
        height = heightTemp;
        startH = startHTemp;
        startW = startWTemp;
    }

    public void move() {
        startW = startW - 10;
    }
}