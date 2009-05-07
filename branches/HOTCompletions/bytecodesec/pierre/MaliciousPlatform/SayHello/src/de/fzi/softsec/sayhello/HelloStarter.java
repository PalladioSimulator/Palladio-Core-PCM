package de.fzi.softsec.sayhello;

import de.fzi.softsec.compplatform.ComponentStarter;

// Referenced classes of package de.fzi.softsec.sayhello:
//            SingingClass

public class HelloStarter
    implements ComponentStarter
{

    public HelloStarter()
    {
    }

    public void start()
    {
        System.out.println("Hello FZ eye !");
        SingingClass singer = new SingingClass();
        singer.sing();
    }

    public void stop()
    {
        System.out.println("Goodbye FZ eye !");
    }
}