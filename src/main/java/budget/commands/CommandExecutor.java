package budget.commands;

public class CommandExecutor {
    private CommandInterface command;

    public void setCommand(CommandInterface command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}
