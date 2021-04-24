public class Bird {

    int speed;
    int height;
    int width;

    Bird(int startH, int startW) {
        height = startH;
        width = startW;
    }

    public void move() {
        height = height + speed;
        speed--;
    }

    public void bounce() {
        if (speed < 0) {
            speed = 10;
        }
    }
}
