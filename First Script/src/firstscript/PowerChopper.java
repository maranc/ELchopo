package firstscript;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Script.Manifest(name = "ELchopo", description = "Cuts that ganja weed and lights it up my dude! Get stoked my dude!", properties = "client=4; topic=0")
public class PowerChopper extends PollingScript<ClientContext> {
    private List<Task> taskList = new ArrayList<Task>();


    @Override
    public void start() {
        log.info("Starting your dank boi");
        taskList.addAll(Arrays.asList(new Chop(ctx),  new Combat(ctx), new Bank(ctx), new CheckBagDraynor(ctx)));
    }

    @Override
    public void poll() {
        Random rand = new Random();
        for (Task task : taskList) {
            int n = rand.nextInt(350) + 250;
            try {
                Thread.sleep(n);
            } catch (InterruptedException e) {
                System.out.println("Caught fool!");
            }
            if (task.activate()) {
                task.execute();
            }
        }
    }
}