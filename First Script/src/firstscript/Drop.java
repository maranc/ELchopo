package firstscript;

import java.util.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.Item;

public class Drop extends Task<ClientContext> {
    private int logIds[] = {1521, 1511};


    public Drop(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count() == 28;
    }

    @Override
    public void execute() {
        ctx.game.tab(Game.Tab.INVENTORY);
        Random rand = new Random();
        for (Item i : ctx.inventory.id(logIds)) {
            int n = rand.nextInt(700) + 300;
            try {
                Thread.sleep(n);
            } catch (InterruptedException e) {
                System.out.println("Caught fool!");
            }
            i.interact("Drop");
        }

    }
}