package firstscript;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.GameObject;


public class Chop extends Task<ClientContext> {
    private int[] treeIds = {1751};


    public Chop(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        ctx.objects.select().id(treeIds);
        GameObject tree = ctx.objects.nearest().poll();
        return ctx.inventory.select().count() < 28
                && !ctx.objects.select().id(treeIds).isEmpty()
                && ctx.players.local().animation() == -1
                && !ctx.players.local().inMotion()
                && !ctx.bank.opened()
                && ((ctx.bank.nearest().tile().distanceTo(tree) > 35) && (tree.inViewport() && ctx.bank.nearest().tile().distanceTo(tree) < 45));

    }

    @Override
    public void execute() {
        ctx.objects.select().id(treeIds);
        GameObject tree = ctx.objects.nearest().poll();
        System.out.println("Running chop");
        System.out.println("Distance from tree picked to bank:");
        System.out.println(ctx.bank.nearest().tile().distanceTo(tree));
        System.out.println("Distance to tree picked:");
        System.out.println(ctx.players.local().tile().distanceTo(tree));
        System.out.println(tree.name());
        if (ctx.game.tab() != Game.Tab.INVENTORY) {
            ctx.game.tab(Game.Tab.INVENTORY);
        }
        //Change this ">/<" for different area (draynor or varrock, etc)
        if ((tree.inViewport() && ctx.bank.nearest().tile().distanceTo(tree) < 45) && (tree.inViewport() && ctx.bank.nearest().tile().distanceTo(tree) > 35)) {
            System.out.println("interact command run");
            tree.interact("Chop", tree.name());
        } else if (!tree.inViewport()) {
            System.out.println("interact command turn tree");
            ctx.movement.step(tree);
            ctx.camera.turnTo(tree);
        } else {
            System.out.println("else command");
            System.out.println(ctx.bank.nearest().tile().distanceTo(tree));
        }
    }
}