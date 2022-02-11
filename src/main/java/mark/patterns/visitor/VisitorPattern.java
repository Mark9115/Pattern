package mark.patterns.visitor;

interface Inspector{
    void visit(Transmission transmission);
    void visit(Engine engine);
    void visit(Wheels wheels);
}
class QualityInspector implements Inspector{

    @Override
    public void visit(Transmission transmission) {
        System.out.println("Inspecting transmission");
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Inspecting engine");
    }

    @Override
    public void visit(Wheels wheels) {
        System.out.println("Inspecting wheels");
    }
}

interface Parts{
    void accept(Inspector inspector);
}

class Transmission implements Parts{
    @Override
    public void accept(Inspector inspector) {
        inspector.visit(this);
    }
}

class Engine implements Parts{
    @Override
    public void accept(Inspector inspector) {
        inspector.visit(this);
    }
}

class Wheels implements Parts{
    @Override
    public void accept(Inspector inspector) {
        inspector.visit(this);
    }
}


public class VisitorPattern {
    public static void main(String[] args) {
        Parts part = new Engine();
        part.accept(new QualityInspector());
        part = new Transmission();
        part.accept(new QualityInspector());
        part = new Wheels();
        part.accept(new QualityInspector());
    }
}
