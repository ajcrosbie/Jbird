public class Bird {

    int speed = 0;
    int size = 40;
    int y;
    int x;

    Bird(int startH, int startW) {
        y = startH;
        x = startW;
    }

    public void move() {
        y = y - speed;
        speed--;
    }

    public void bounce() {
        if (speed < 0) {
            speed = 13;
        }
    }
}
