package firstscript;

import org.powerbot.script.rt4.ClientContext;

public class Test extends Task<ClientContext> {

    public Test(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return true;
    }

    @Override
    public void execute() {

    }
}
