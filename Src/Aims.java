public class Aims {

    public static void main(String[] args) {
        // Tạo giỏ hàng mới
        Cart customerCart = new Cart();

        // Tạo các đối tượng DVD mới và thêm chúng vào giỏ hàng
        DigitalVideoDisc lionKingDvd = new DigitalVideoDisc("The Lion King", 
            "Animation", "Roger Allers", 87, 19.95f);
        customerCart.addDiscToCart(lionKingDvd);

        DigitalVideoDisc starWarsDvd = new DigitalVideoDisc("Star Wars", 
            "Science Fiction", "George Lucas", 87, 24.95f);
        customerCart.addDiscToCart(starWarsDvd);

        DigitalVideoDisc aladdinDvd = new DigitalVideoDisc("Aladdin", 
            "Animation", 18.99f);
        customerCart.addDiscToCart(aladdinDvd);

        // In tổng chi phí của các sản phẩm trong giỏ hàng
        System.out.println("Total Cost is: ");
        System.out.println(customerCart.calculateTotalCost());
    }
}
