package myNameActorModel;

        import akka.actor.typed.ActorSystem;

public class myNameApp {
    public static void main(String[] args) {
        ActorSystem<myName.Command> mySystem = ActorSystem.create(myName.create(), "MySystem");

        String[] lista = new String[]{"M","I","G","U","E","L"};

        for (String letra : lista){
            mySystem.tell(new myName.ChangeMessage(letra));
            mySystem.tell(myName.SayHellow.Instance);
        }
    }
}
