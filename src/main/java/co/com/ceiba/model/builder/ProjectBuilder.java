package co.com.ceiba.model.builder;

import co.com.ceiba.model.enums.Template;
import co.com.ceiba.model.enums.Visibility;
import co.com.ceiba.model.Project;

public class ProjectBuilder {

    private String name;
    private String slug;
    private String description;
    private Visibility visibility;
    private Boolean initializeReadme;
    private Template template;


    private ProjectBuilder(String name) {
        this.name = name;
        this.slug = "";
        this.description = "";
        this.visibility = Visibility.PUBLIC;
        this.initializeReadme = false;
        this.template = Template.SPRING;
    }


    public static ProjectBuilder name(String name) {
        return new ProjectBuilder(name);
    }

    public ProjectBuilder slug(String slug) {
        this.slug = slug;
        return this;
    }

    public ProjectBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProjectBuilder visibility(Visibility visibility) {
        this.visibility = visibility;
        return this;
    }

    public ProjectBuilder initializeReadme(Boolean initializeReadme) {
        this.initializeReadme = initializeReadme;
        return this;
    }

    public ProjectBuilder template(Template template) {
        this.template = template;
        return this;
    }


    public Project build() {
        return new Project(
                this.name,
                this.slug,
                this.description,
                this.visibility,
                this.initializeReadme,
                this.template
        );
    }
}
