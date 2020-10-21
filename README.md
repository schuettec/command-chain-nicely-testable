# command-chain-nicely-testable
A nifty command chain implementation that is nicely testable.

This project contains a simple command chain implementation. It is simple, but the test is interesting: You can write short and readable assertions on every command that is executed!

The assertions are made by implementing a short builder and an equals-method in the commands. This
makes the test so awesomely readable :-P
