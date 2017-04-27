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
                new Tile(3109, 3239, 0),
                new Tile(3113, 3246, 0),
                new Tile(3115, 3255, 0),
                new Tile(3108, 3249, 0),
                new Tile(3107, 3260, 0),
                new Tile(3104, 3269, 0),
                new Tile(3106, 3280, 0),
                new Tile(3110, 3293, 0),
                new Tile(3098, 3295, 0),
                new Tile(3102, 3284, 0),
                new Tile(3094, 3282, 0),
                new Tile(3087, 3278, 0),
                new Tile(3083, 3271, 0),
                new Tile(3082, 3263, 0),
                new Tile(3081, 3252, 0),
                new Tile(3086, 3249, 0),
                new Tile(3095, 3243, 0)
        };
        TilePath path = ctx.movement.newTilePath(tilesToWalk);
        path.traverse();
    }
}