package week5.join;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _02ThreadJoin {

    public static void main(String[] args) {

        File folder = new File("C:\\Users\\VS\\IdeaProjects\\ACP2023");

        File[] files = folder.listFiles();
        List<Thread> threads = new ArrayList<>();
        List<AsynchrSearchTask> tasks = new ArrayList<>();
        List<File>results = new ArrayList<>();

        for (File file : files) {
            if (file.isDirectory()) {
                AsynchrSearchTask task = new AsynchrSearchTask(file, "Robot");
                Thread thread = new Thread(task);
                threads.add(thread);
                tasks.add(task);

                thread.start();
            }
        }

        for (Thread thread: threads) {
            try {
                thread.join(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (AsynchrSearchTask task : tasks) {
            List<File> result = task.getRes();
            results.addAll(result);
        }
        results.forEach(System.out::println);
    }
}

class AsynchrSearchTask implements Runnable {

    private File root;
    private String keyWord;
    private List<File> searchResult;

    public AsynchrSearchTask(File root, String keyWord) {
        this.root = root;
        this.keyWord = keyWord;
        searchResult = new ArrayList<>();
    }

    @Override
    public void run() {
        recSearch(root);
    }

    private void recSearch(File directRoot) {
        if (root == null) {
            return;
        }

        File[] files = directRoot.listFiles();
        if (files == null || files.length == 0) {
            return;
        }

        Arrays.stream(files)
                .forEach((file) -> {
                    if (file.isDirectory()) {
                        recSearch(file);
                    } else if (file.getName().contains(keyWord)) {
                        searchResult.add(file);
                    }
                });
    }

    public List<File> getRes() {
        return searchResult;
    }
}