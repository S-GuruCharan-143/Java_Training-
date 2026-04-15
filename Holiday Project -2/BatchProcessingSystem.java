import java.util.ArrayList;
import java.util.List;
class InvalidJobException extends Exception {
    public InvalidJobException(String message) {
        super(message);
    }
}
class JobExecutionException extends Exception {
    public JobExecutionException(String message) {
        super(message);
    }
}
enum JobStatus {
    PENDING,
    RUNNING,
    COMPLETED,
    FAILED
}
abstract class Job {
    private int jobId;
    private String jobName;
    private JobStatus status;

    public Job(int jobId, String jobName) throws InvalidJobException {
        if (jobName == null || jobName.trim().isEmpty()) {
            throw new InvalidJobException("Job name cannot be empty.");
        }
        this.jobId = jobId;
        this.jobName = jobName;
        this.status = JobStatus.PENDING;
    }
    public int getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public JobStatus getStatus() {
        return status;
    }
    public void setStatus(JobStatus status) {
        this.status = status;
    }
    public void displayInfo() {
        System.out.println("Job ID: " + jobId + ", Job Name: " + jobName + ", Status: " + status);
    }
    public abstract void execute() throws JobExecutionException;
}

class DataProcessingJob extends Job {
    private String inputData;
    private String operationType;

    public DataProcessingJob(int jobId, String jobName,
                             String inputData, String operationType)
            throws InvalidJobException {
        super(jobId, jobName);

        if (inputData == null || inputData.trim().isEmpty()) {
            throw new InvalidJobException("Input data cannot be empty.");
        }
        if (operationType == null || operationType.trim().isEmpty()) {
            throw new InvalidJobException("Operation type cannot be empty.");
        }

        this.inputData = inputData;
        this.operationType = operationType;
    }

    @Override
    public void execute() throws JobExecutionException {
        System.out.println("Processing data: " + inputData +
                " with operation: " + operationType);
    }
}
class EmailJob extends Job {
    private String recipientEmail;
    private String subject;
    private String message;

    public EmailJob(int jobId, String jobName,
                    String recipientEmail, String subject, String message)
            throws InvalidJobException {
        super(jobId, jobName);

        if (recipientEmail == null || !recipientEmail.contains("@")) {
            throw new InvalidJobException("Invalid recipient email.");
        }
        if (subject == null || subject.trim().isEmpty()) {
            throw new InvalidJobException("Subject cannot be empty.");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new InvalidJobException("Message cannot be empty.");
        }

        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.message = message;
    }

    @Override
    public void execute() throws JobExecutionException {
        System.out.println("Sending email to: " + recipientEmail);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
class ReportGenerationJob extends Job {
    private String reportType;
    private String outputPath;

    public ReportGenerationJob(int jobId, String jobName,
                               String reportType, String outputPath)
            throws InvalidJobException {
        super(jobId, jobName);

        if (reportType == null || reportType.trim().isEmpty()) {
            throw new InvalidJobException("Report type cannot be empty.");
        }
        if (outputPath == null || outputPath.trim().isEmpty()) {
            throw new InvalidJobException("Output path cannot be empty.");
        }

        this.reportType = reportType;
        this.outputPath = outputPath;
    }

    @Override
    public void execute() throws JobExecutionException {
        System.out.println("Generating " + reportType +
                " report at: " + outputPath);
    }
}
class Batch {
    private int batchId;
    private String batchName;
    private List<Job> jobs;

    public Batch(int batchId, String batchName) throws InvalidJobException {
        if (batchName == null || batchName.trim().isEmpty()) {
            throw new InvalidJobException("Batch name cannot be empty.");
        }
        this.batchId = batchId;
        this.batchName = batchName;
        this.jobs = new ArrayList<>();
    }

    public void addJob(Job job) {
        if (job == null) {
            throw new IllegalArgumentException("Job cannot be null.");
        }
        jobs.add(job);
    }

    public void removeJob(Job job) {
        jobs.remove(job);
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public int getBatchId() {
        return batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void displayBatchDetails() {
        System.out.println("Batch ID: " + batchId + ", Batch Name: " + batchName);
    }
}
class BatchProcessor {

    public void processBatch(Batch batch) {
        System.out.println("\nProcessing Batch: " + batch.getBatchName());
        System.out.println("-------------------------------------");

        for (Job job : batch.getJobs()) {
            try {
                job.setStatus(JobStatus.RUNNING);
                System.out.println("\nExecuting Job: " + job.getJobName());
                job.execute();
                job.setStatus(JobStatus.COMPLETED);
                System.out.println("Status: COMPLETED");
            } catch (JobExecutionException e) {
                job.setStatus(JobStatus.FAILED);
                System.out.println("Status: FAILED - " + e.getMessage());
            }
        }
    }

    public void generateSummary(Batch batch) {
        int completed = 0;
        int failed = 0;

        for (Job job : batch.getJobs()) {
            if (job.getStatus() == JobStatus.COMPLETED)
                completed++;
            else if (job.getStatus() == JobStatus.FAILED)
                failed++;
        }

        System.out.println("\n----- Batch Summary -----");
        System.out.println("Total Jobs: " + batch.getJobs().size());
        System.out.println("Completed: " + completed);
        System.out.println("Failed: " + failed);
    }
}

public class BatchProcessingSystem {
    public static void main(String[] args) {
        try {
            Batch batch = new Batch(101, "Nightly Processing");
            Job job1 = new DataProcessingJob(
                    1, "Clean Customer Data", "customer.csv", "CLEAN");

            Job job2 = new EmailJob(
                    2, "Send Notification",
                    "user@example.com",
                    "Process Complete",
                    "Your data has been successfully processed.");

            Job job3 = new ReportGenerationJob(
                    3, "Generate Sales Report",
                    "Sales", "/reports/sales.pdf");

            batch.addJob(job1);
            batch.addJob(job2);
            batch.addJob(job3);
            batch.displayBatchDetails();
            BatchProcessor processor = new BatchProcessor();
            processor.processBatch(batch);
            processor.generateSummary(batch);

        } catch (InvalidJobException e) {
            System.out.println("Initialization Error: " + e.getMessage());
        }
    }
}