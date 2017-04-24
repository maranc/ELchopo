package firstscript;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.GameObject;
import java.util.Random;

public class Chop extends Task<ClientContext> {
    private int[] treeIds = {1751};

    public Chop(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count() < 28
                && !ctx.objects.select().id(treeIds).isEmpty()
                && ctx.players.local().animation() == -1
                && !ctx.players.local().inMotion();
    }

    @Override
    public void execute() {
        System.out.println("Yo let's chop this shit ma nigga I'm down to get lit doggo");
        GameObject tree = ctx.objects.nearest().poll();
        if (ctx.game.tab() != Game.Tab.INVENTORY) {
            ctx.game.tab(Game.Tab.INVENTORY);
        }
        if (tree.inViewport()) {
            tree.interact("Chop");
        } else {
            ctx.movement.step(tree);
            ctx.camera.turnTo(tree);
        }
    }
}