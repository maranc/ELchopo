package firstscript;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;

public class CheckBag extends Task<ClientContext> {

    public CheckBag(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (ctx.game.tab() != Game.Tab.INVENTORY);
    }

    @Override
    public void execute() {

    }
}

