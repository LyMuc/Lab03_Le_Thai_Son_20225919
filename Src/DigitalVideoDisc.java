public class DigitalVideoDisc {

    private static int discCount = 0;

    private int duration;
    private float price;
    private String name;
    private String genre;
    private String producer;
    private int discID;

    public DigitalVideoDisc(String name) {
        this.name = name;
        this.discID = ++discCount;
    }

    public DigitalVideoDisc(String name, String genre, float price) {
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.discID = ++discCount;
    }

    public DigitalVideoDisc(String name, String genre, String producer, float price) {
        this.name = name;
        this.genre = genre;
        this.producer = producer;
        this.price = price;
        this.discID = ++discCount;
    }

    public DigitalVideoDisc(String name, String genre, String producer, int duration, float price) {
        this.name = name;
        this.genre = genre;
        this.producer = producer;
        this.duration = duration;
        this.price = price;
        this.discID = ++discCount;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public int getDiscID() {
        return discID;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String newProducer) {
        producer = newProducer;
    }

    public void setDuration(int newDuration) {
        duration = newDuration;
    }

    public void setPrice(float newPrice) {
        price = newPrice;
    }

    public void setGenre(String newGenre) {
        genre = newGenre;
    }

    public void setName(String newName) {
        name = newName;
    }
}
