package firstscript;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.TilePath;
import org.powerbot.script.Tile;

public class CheckBagDraynor extends Task<ClientContext> {
    private int[] treeIds = {1751};

    public CheckBagDraynor(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        ctx.objects.select().id(treeIds);
        GameObject tree = ctx.objects.nearest().poll();
        return (ctx.inventory.select().count() == 28 && !ctx.bank.inViewport() && !ctx.players.local().inMotion())
                || (ctx.inventory.select().count() < 2 && ctx.bank.opened() && !ctx.players.local().inMotion() && (ctx.bank.nearest().tile().distanceTo(tree) < 35))
                || (ctx.bank.nearest().tile().distanceTo(tree) < 35);
    }

    @Override
    public void execute() {
        System.out.println("starting CheckBag");
        ctx.objects.select().id(treeIds);
        GameObject tree = ctx.objects.nearest().poll();
        System.out.println(tree.name());
        if (ctx.inventory.select().count() == 28 && !ctx.bank.inViewport()) {
            System.out.println("walking to the bank yo, your bags are full dude");
            Tile[] tilesToBank = new Tile[] {
                    new Tile(3105, 3285, 0),
                    new Tile(3103, 3292, 0),
                    new Tile(3102, 3285, 0),
                    new Tile(3094, 3282, 0),
                    new Tile(3086, 3277, 0),
                    new Tile(3084, 3268, 0),
                    new Tile(3081, 3259, 0),
                    new Tile(3084, 3249, 0),
                    new Tile(3094, 3243, 0)
            };
            TilePath path = ctx.movement.newTilePath(tilesToBank);
            path.traverse();
            if (ctx.bank.nearest().tile().distanceTo(ctx.players.local()) < 10) {
                ctx.movement.step(ctx.bank.nearest());
                ctx.camera.turnTo(ctx.bank.nearest());
            }
        } else if((ctx.inventory.select().count() < 2 && ctx.bank.opened()) || (ctx.inventory.select().count() < 2 && ctx.bank.nearest().tile().distanceTo(tree) < 35)) {
            Tile[] tilesToTrees = new Tile[] {
                    new Tile(3094, 3244, 0),
                    new Tile(3092, 3248, 0),
                    new Tile(3087, 3248, 0),
                    new Tile(3082, 3251, 0),
                    new Tile(3082, 3256, 0),
                    new Tile(3082, 3262, 0),
                    new Tile(3083, 3269, 0),
                    new Tile(3085, 3275, 0),
                    new Tile(3089, 3279, 0),
                    new Tile(3094, 3283, 0),
                    new Tile(3100, 3285, 0)
            };
            TilePath path = ctx.movement.newTilePath(tilesToTrees);
            path.traverse();
        } /*else if (ctx.bank.nearest().tile().distanceTo(ctx.players.local()) > 5) {
            Tile[] tilesFromLost = new Tile[] {
                    new Tile(3276, 3418, 0),
                    new Tile(3281, 3412, 0),
                    new Tile(3289, 3411, 0),
                    new Tile(3290, 3400, 0),
                    new Tile(3290, 3391, 0),
                    new Tile(3292, 3384, 0),
                    new Tile(3293, 3392, 0),
                    new Tile(3294, 3400, 0),
                    new Tile(3294, 3407, 0),
                    new Tile(3294, 3413, 0),
                    new Tile(3292, 3420, 0),
                    new Tile(3291, 3426, 0),
                    new Tile(3289, 3432, 0),
                    new Tile(3289, 3438, 0),
                    new Tile(3287, 3444, 0),
                    new Tile(3281, 3448, 0),
                    new Tile(3276, 3444, 0),
                    new Tile(3281, 3440, 0),
                    new Tile(3284, 3435, 0),
                    new Tile(3284, 3430, 0),
                    new Tile(3284, 3424, 0),
                    new Tile(3284, 3418, 0)
            };
            TilePath path = ctx.movement.newTilePath(tilesFromLost);
            path.traverse();
        }*/
    }
}


