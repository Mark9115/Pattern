package mark.patterns.builder;

import java.util.Date;

class Order {
    private final int id;
    private final String name;
    private final String description;
    private final String comment;
    private final boolean done;
    private final Date dueDate;


    public Order(int id, String name, String description, String comment, boolean done,Date dueDate) {
        this.id = id;
        this.comment = comment;
        this.name = name;
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", comment='" + comment + '\'' +
                ", done=" + done +
                ", dueDate=" + dueDate +
                '}';
    }
}

class OrderBuilder {

    private final int id;
    private String name;
    private String description;
    private String comment;
    private boolean done;
    private Date dueDate;

    public OrderBuilder(int id) {
        this.id = id;
    }

    public OrderBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public OrderBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public OrderBuilder setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrderBuilder setDone(boolean done) {
        this.done = done;
        return this;
    }

    public OrderBuilder setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Order build() {
        return new Order(id, name, description, comment, done, dueDate);
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Order order1 = new OrderBuilder(1).setComment("should be done").setDueDate(new Date()).build();
        System.out.println(order1);
        Order order2 = new OrderBuilder(2).setName("order 2").setDone(true).setDescription("Ordered").build();
        System.out.println(order2);
        Order order3 = new OrderBuilder(3).build();
        System.out.println(order3);
    }
}
