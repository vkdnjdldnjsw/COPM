/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.data;

import copm.model.container.Project;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Arsene holmes
 */
public class ProjectData extends NetworkData implements Serializable{
    private Project project;
    
    public ProjectData() {
        super(NetworkData.PROJECTDATA);
    }
    public void setProject(Project project){
        this.project = project;
    }
    public Project getProject(){
        return project;
    }
    
}
