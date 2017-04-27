package firstscript;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import java.util.Random;

public class Bank extends Task<ClientContext> {
    private int logIds[] = {1521, 1511};

    public Bank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (ctx.bank.inViewport() && ctx.inventory.select().count() == 28)
                || (ctx.bank.opened() && ctx.inventory.select().count() == 28);
    }

    @Override
    public void execute() {
        if (ctx.bank.opened()) {
            Random rand = new Random();
            int n = rand.nextInt(300) + 250;
            for (Item i : ctx.inventory.id(logIds)) {
                try{
                    Thread.sleep(n);
                }catch(InterruptedException e) {
                    System.out.println("Caught fool!");
                }
                i.interact("DEPOSIT-ALL");
            }
        } else {
            ctx.bank.open();
        }
    }
}
