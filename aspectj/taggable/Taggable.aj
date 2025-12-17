public aspect Taggable {

    declare parents: Product implements ITaggable;

    private String Product.tag;

    public void Product.setTag(String tag) {
        this.tag = tag;
    }

    public String Product.getTag() {
        return this.tag;
    }

}
