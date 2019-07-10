package co.com.ceiba.model;

import co.com.ceiba.exceptions.ProjectException;
import co.com.ceiba.model.enums.Template;
import co.com.ceiba.model.enums.Visibility;
import co.com.ceiba.util.validations.Validations;

public class Project {

    private final String NAME_NULL = "El nombre no debe ser nulo";
    private final String SLUG_NULL = "El slug no debe ser nulo";
    private final String DESCRIPTION_NULL = "La descripcion no debe ser nula";
    private final String VISIBILITY_NULL = "La visibilidad no debe ser nula";
    private final String README_NULL = "El initial readme no debe ser nulo";
    private final String TEMPLATE_NULL = "El template no debe ser nulo";


    private String name;
    private String slug;
    private String description;
    private Visibility visibility;
    private Boolean initializeReadme;
    private Template template;


    public Project(
            String name,
            String slug,
            String description,
            Visibility visibility,
            Boolean initializeReadme,
            Template template
    ) {

        this.validateNotNull(name, NAME_NULL);
        this.validateNotNull(slug, SLUG_NULL);
        this.validateNotNull(description, DESCRIPTION_NULL);
        this.validateNotNull(visibility, VISIBILITY_NULL);
        this.validateNotNull(initializeReadme, README_NULL);
        this.validateNotNull(template, TEMPLATE_NULL);

        this.name = name;
        this.slug = slug;
        this.description = description;
        this.visibility = visibility;
        this.initializeReadme = initializeReadme;
        this.template = template;
    }


    private void validateNotNull(Object variable, String messageError) {
        if (Validations.isNull(variable)) {
            throw new ProjectException(messageError);
        }
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getDescription() {
        return description;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public Boolean getInitializeReadme() {
        return initializeReadme;
    }

    public Template getTemplate() {
        return template;
    }
}
