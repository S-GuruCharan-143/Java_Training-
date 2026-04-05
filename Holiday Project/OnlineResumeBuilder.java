import java.util.ArrayList;
import java.util.List;

class InvalidEmailException extends Exception{
    public InvalidEmailException(String str){
        super(str);
    }
}
class InvalidNumberException extends Exception{
    public InvalidNumberException(String str){
        super(str);
    }
}
class InvalidEntryException extends Exception{
    public InvalidEntryException(String str){
        super(str);
    }
}
abstract class Section{
    private String sectionTitle;
    public Section(String sectionTitle){
        this.sectionTitle=sectionTitle;
    }
    public String getTitle(){
        return sectionTitle;
    }
    abstract void display();
}
class PersonalInfoSection extends Section{
    private String name;
    private String email;
    private String phoneNo;
    private String address;
    PersonalInfoSection(String name,String email,String phoneNo,String address)throws InvalidEmailException,InvalidNumberException,InvalidEntryException{
        if(name==null){
            throw new InvalidEntryException("Name Cannot Be Empty");
        }
        if(!email.contains("@")){
            throw new InvalidEmailException("Invalid Email Entered");
        }
        if(phoneNo.length()!=10){
            throw new InvalidNumberException("Invalid Number Length");
        }
        super("PersonalInfo");
        this.name=name;
        this.email=email;
        this.phoneNo=phoneNo;
        this.address=address;
    }
    void display(){
        System.out.println("------"+getTitle()+"------\n");
        System.out.println("Name: "+name+"\n"+"Email: "+email+"\n"+"Phone Number: "+phoneNo+"\n"+"Address: "+address+"\n");
    }
}
class EducationEntry{
    private String degree;
    private String institution;
    private int year;
    private int grade;
    public EducationEntry(String degree,String institution,int year, int grade)throws InvalidEntryException{
        if(degree==null || institution==null){
            throw new InvalidEntryException("Invalid Entry");
        }
        if(!(grade>0 && grade<=10)){
            throw new InvalidEntryException("Grade Should Be Between 0 & 10");
        }
        this.degree=degree;
        this.institution=institution;
        this.year=year;
        this.grade=grade;
    }
    public void getDetails(){
        System.out.println("Degree: "+degree+"\n"+"Institution: "+institution+"\n"+"Year: "+year+"\n"+"Grade: "+grade+"\n");
    }
}
class EducationSection extends Section{
    private List<EducationEntry> educationList;
    public EducationSection(){
        super("Education");
        educationList=new ArrayList<>();
    }
    public void addEducation(EducationEntry entry){
        if(entry==null){
            throw new IllegalArgumentException("Education Cannot be null");
        }
        educationList.add(entry);
    }
    public void removeEducation(EducationEntry entry){
        educationList.remove(entry);
    }
    void display(){
        System.out.println("------"+getTitle()+"------\n");
        for(EducationEntry ed:educationList){
            ed.getDetails();
        }
    }
}
class ExperienceEntry{
    private String company;
    private String role;
    private int duration;
    private String description;
    ExperienceEntry(String company,String role,int duration,String description)throws InvalidEntryException{
        if(!(duration>0)){
            throw new InvalidEntryException("Duration Should Be Positive");
        }
        this.company=company;
        this.role=role;
        this.duration=duration;
        this.description=description;
    }
    public void getDetails(){
        System.out.println("Company: "+company+"\n"+"Role: "+role+"\n"+"Duration: "+duration+"Months\n"+"Description: "+description+"\n");
    }
}
class ExperienceSection extends Section{
    private List<ExperienceEntry> experienceList;
    ExperienceSection(){
        super("Experience");
        experienceList=new ArrayList<>();
    }
    void addExperience(ExperienceEntry entry){
        if(entry==null){
            throw new IllegalArgumentException("Experience Cannnot be null");
        }
        experienceList.add(entry);
    }
    void removeExperience(ExperienceEntry entry){
        experienceList.remove(entry);
    }
    void display(){
        System.out.println("------"+getTitle()+"------\n");
        for(ExperienceEntry exp:experienceList){
            exp.getDetails();
        }
    }
}
class SkillsSection extends Section{
    private List<String> skills;
    SkillsSection(){
        super("Skills");
        skills=new ArrayList<>();
    }
    void addSkill(String skill)throws InvalidEntryException{
        if(skill==null){
            throw new InvalidEntryException("Skill Cannot Be Empty");
        }
        if(skills.contains(skill)){
            throw new InvalidEntryException("Skill Already Entered");
        }
        skills.add(skill);
    }
    void removeSkill(String skill){
        skills.remove(skill);
    }
    void display(){
        System.out.println("------"+getTitle()+"------\n");
        for(String str:skills){
            System.out.println("->"+str);
        }
        System.out.print("\n");
    }
}
class ProjectSection extends Section{
    private List<String> projects;
    ProjectSection(){
        super("Projects");
        projects=new ArrayList<>();
    }
    void addProject(String project)throws InvalidEntryException{
        if(project==null){
            throw new InvalidEntryException("Project Cannot Be Empty");
        }
        if(projects.contains(project)){
            throw new InvalidEntryException("Project Already Entered");
        }
        projects.add(project);
    }
    void removeProject(String project){
        projects.remove(project);
    }
    void display(){
        System.out.println("------"+getTitle()+"------\n");
        for(String str:projects){
            System.out.println("->"+str);
        }
        System.out.print("\n");
    }
}
class Resume{
    List<Section> sections;
    int resumeId;
    String userName;
    Resume(int resumeId,String userName){
        sections=new ArrayList<>();
        this.resumeId=resumeId;
        this.userName=userName;
    }
    void addSection(Section sec){
        if(sec==null){
            throw new IllegalArgumentException("Section Cannot be null");
        }
        sections.add(sec);
    }
    void removeSection(Section sec){
        sections.remove(sec);
    }
    void generateResume(){
        System.out.println("\n--------"+"Resume"+"--------\n\n");
        for(Section sec:sections){
            sec.display();
        }
    }
}

public class OnlineResumeBuilder{
    public static void main(String[] args)throws Exception {
        Resume rem=new Resume(01,"Gg");
        PersonalInfoSection per=new PersonalInfoSection("gg", "gg@gamail.com"   , "9838388233", "chennai");
        EducationSection edu=new EducationSection();
        ExperienceSection exp=new ExperienceSection();
        SkillsSection ski=new SkillsSection();
        ProjectSection pro=new ProjectSection();
        edu.addEducation(new EducationEntry("B.Tech CSE", "XYZ College", 2026, 9));
        edu.addEducation(new EducationEntry("12th", "ABC School", 2022, 9));
        exp.addExperience(new ExperienceEntry("Google", "Intern", 6, "Worked on backend"));
        exp.addExperience(new ExperienceEntry("Startup", "Developer", 12, "Built web app"));
        ski.addSkill("Java");
        ski.addSkill("Python");
        ski.addSkill("Data Structures");
        pro.addProject("Resume Builder App");
        pro.addProject("2D Game in Python");
        rem.addSection(per);
        rem.addSection(edu);
        rem.addSection(exp);
        rem.addSection(ski);
        rem.addSection(pro);
        rem.generateResume();
    }
}