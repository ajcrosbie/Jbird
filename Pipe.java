public class Pipe {
    int width = 100;
    int height;
    int x;
    int y;

    Pipe(int heightTemp, int startHTemp, int startWTemp) {
        height = heightTemp;
        y = startHTemp;
        x = startWTemp;
    }

    public void move() {
        x = x - 10;
    }
}