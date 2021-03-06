package firstscript;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.TilePath;
import org.powerbot.script.Tile;

public class CheckBag extends Task<ClientContext> {
    private int[] treeIds = {1276, 1278};

    public CheckBag(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        ctx.objects.select().id(treeIds);
        GameObject tree = ctx.objects.nearest().poll();
        return (ctx.inventory.select().count() == 28 && !ctx.bank.inViewport())
                || (ctx.inventory.select().count() < 2 && ctx.bank.opened())
                || (ctx.bank.nearest().tile().distanceTo(tree) > 35);
    }

    @Override
    public void execute() {
        ctx.objects.select().id(treeIds);
        GameObject tree = ctx.objects.nearest().poll();
        System.out.println(ctx.bank.nearest().tile().distanceTo(tree));

        if (ctx.inventory.select().count() == 28 && !ctx.bank.inViewport()) {
            System.out.println("walking to the bank yo, your bags are full dude");
            Tile[] tilesToBank = new Tile[] {
                    new Tile(3278, 3416, 0),
                    new Tile(3282, 3412, 0),
                    new Tile(3286, 3417, 0),
                    new Tile(3284, 3424, 0),
                    new Tile(3285, 3430, 0),
                    new Tile(3284, 3436, 0),
                    new Tile(3284, 3442, 0),
                    new Tile(3281, 3448, 0),
                    new Tile(3279, 3443, 0),
                    new Tile(3280, 3437, 0),
                    new Tile(3279, 3431, 0),
                    new Tile(3279, 3426, 0),
                    new Tile(3273, 3428, 0),
                    new Tile(3267, 3428, 0),
                    new Tile(3261, 3428, 0),
                    new Tile(3254, 3421, 0)
            };
            TilePath path = ctx.movement.newTilePath(tilesToBank);
            path.traverse();
            if (ctx.bank.nearest().tile().distanceTo(ctx.players.local()) < 10) {
                ctx.camera.turnTo(ctx.bank.nearest().tile());
            }
        } else if(ctx.inventory.select().count() < 2 && ctx.bank.opened()) {
            Tile[] tilesToTrees = new Tile[] {
                    new Tile(3254, 3421, 0),
                    new Tile(3254, 3428, 0),
                    new Tile(3263, 3429, 0),
                    new Tile(3274, 3429, 0),
                    new Tile(3281, 3423, 0)
            };
            TilePath path = ctx.movement.newTilePath(tilesToTrees);
            path.traverse();
        } else if (ctx.bank.nearest().tile().distanceTo(ctx.players.local()) > 5) {
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
        }
    }
}


