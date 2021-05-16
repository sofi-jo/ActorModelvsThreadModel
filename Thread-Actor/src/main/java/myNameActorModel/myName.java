package myNameActorModel;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;


public class myName extends AbstractBehavior<myName.Command> {

    interface Command {}

    public enum SayHellow implements Command{
        Instance
    }

    public static class ChangeMessage implements Command{
        public final String newMessage;

        public ChangeMessage(String newMessage){
            this.newMessage = newMessage;
        }
    }

    public static Behavior<Command> create(){
        return Behaviors.setup(context -> new myName(context));
    }

    private Integer num;
    private String message = "Nombre";


    private myName(ActorContext<Command> context){
        super(context);
    }

    @Override
    public Receive<Command> createReceive() {
        return newReceiveBuilder().onMessageEquals(SayHellow.Instance, this::onSayHello)
                .onMessage(ChangeMessage.class, this::onChangeMessage)
                .build();
    }

    private Behavior<Command> onIsPrime(ChangeMessage command){
        message = command.newMessage;
        return this;
    }
    private Behavior<Command> onChangeMessage(ChangeMessage command){
        message = command.newMessage;
        return this;
    }

    private Behavior<Command> onSayHello(){
        System.out.println(message);
        return this;
    }
}
