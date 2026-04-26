package com.example.demo.model;

public class Task {

    private String id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private String reasoning;

    public Task(String id, String title, String description, String status, String priority, String reasoning) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.reasoning = reasoning;
    }

    public Task() {}

    public String getId() { 
    	return id; 
    	}
    
    public void setId(String id) {
    	this.id = id; 
    	}

    public String getTitle() { 
    	return title; 
    	}
    
    public void setTitle(String title) { 
    	this.title = title; 
    	}

    public String getDescription() { 
    	return description; 
    	}
    
    public void setDescription(String description) { 
    	this.description = description; 
    	}

    public String getStatus() { 
    	return status; 
    	}
    
    public void setStatus(String status) { 
    	this.status = status; 
    	}

    public String getPriority() { 
    	return priority; 
    	}
    
    public void setPriority(String priority) { 
    	this.priority = priority; 
    	}

    public String getReasoning() { 
    	return reasoning; 
    	}
    
    public void setReasoning(String reasoning) { 
    	this.reasoning = reasoning; 
    	}
}