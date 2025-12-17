public class Main {

    public static void main(String[] args) {
        Product p = new Product("Laptop");

        // Cast to the interface introduced by the aspect
        ITaggable taggedItem = (ITaggable) p;

        taggedItem.setTag("Electronics");
        System.out.println("Product: " + p.getName() + " | Tag: " + taggedItem.getTag());
    }

}

/*
 * expected:
 *
 * Product: Laptop | Tag: Electronics
 */
