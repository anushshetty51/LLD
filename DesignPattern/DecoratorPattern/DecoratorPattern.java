interface TextView{
    void render();
}

class SimpleTextView implements TextView{
    private String text;

    public SimpleTextView(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.print("Rendering Text: " + text);
    }
}


abstract class TextViewDecorator implements TextView{
    protected TextView decoratedTextView;

    public TextViewDecorator(TextView decoratedTextView) {
        this.decoratedTextView = decoratedTextView;
    }

    @Override
    public void render() {
        decoratedTextView.render();
    }
}

class BoldDecorator extends TextViewDecorator{
    public BoldDecorator(TextView decoratedTextView) {
        super(decoratedTextView);
    }

    @Override
    public void render() {
        System.out.print("<b>");
        super.render();
        System.out.print("</b>");
    }
}

class ItalicDecorator extends TextViewDecorator{
    public ItalicDecorator(TextView decoratedTextView) {
        super(decoratedTextView);
    }

    @Override
    public void render() {
        System.out.print("<i>");
        super.render();
        System.out.print("</i>");
    }
}

class DecoratorPatternDemo{
    public static void main(String[] args) {
        TextView simpleTextView = new SimpleTextView("Hello, World!");
        TextView boldTextView = new BoldDecorator(simpleTextView);
        TextView italicBoldTextView = new ItalicDecorator(boldTextView);

        System.out.println("Simple Text View:");
        simpleTextView.render();

        System.out.println("\nBold Text View:");
        boldTextView.render();

        System.out.println("\nItalic Bold Text View:");
        italicBoldTextView.render();
    }
}