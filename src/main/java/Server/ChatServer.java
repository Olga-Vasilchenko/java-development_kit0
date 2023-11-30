package Server;

    public class ChatServer implements ServerListener {
        boolean isServerWorking;
        private final Listener listener;

        public ChatServer(Listener listener) {
            this.listener = listener;
            this.isServerWorking = false;
        }

        public void run() {
            if (!isServerWorking) {
                isServerWorking = true;
                listener.messageRes("Статус сервера: " + String.valueOf(true));
            } else {
                listener.messageRes("Сервер запущен");
            }

        }

        public void stop() {
            if (isServerWorking) {
                isServerWorking = false;
                listener.messageRes("Статус сервера: " + String.valueOf(false));
            } else {
                listener.messageRes("Сервер не запущен");
            }
        }

        @Override
        public void listenKey(boolean status) {
            if (status) {
                run();
            } else {
                stop();
            }
        }
    }
