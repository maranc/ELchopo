package firstscript;


import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.TilePath;
import org.powerbot.script.Tile;

public class Combat extends Task<ClientContext> {

    private TilePath pathToBank;

    public Combat(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.players.local().inCombat();
    }

    @Override
    public void execute() {
        Tile[] tilesToWalk = new Tile[] {
                new Tile(3154, 3224, 0),
                new Tile(3160, 3214, 0),
                new Tile(3169, 3219, 0),
                new Tile(3177, 3225, 0),
                new Tile(3184, 3217, 0),
                new Tile(3192, 3210, 0),
                new Tile(3198, 3218, 0),
                new Tile(3203, 3209, 0),
                new Tile(3213, 3206, 0),
                new Tile(3221, 3212, 0),
                new Tile(3221, 3219, 0)
        };
        TilePath path = ctx.movement.newTilePath(tilesToWalk);
        path.traverse();
    }
}