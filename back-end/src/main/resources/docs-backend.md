- #### When find all User, Infinitive loop will appear and cause stackoverflow exception:
  <font color = yellow>cause</font>: User class and Role class are bidirectional one-to-many/many-to-one relationship. When we use spring data JPA, 
  there will be a role object in User class and a list of users in Role class. When we query user through JPA, the role object
  will be queried as well, but when querying role, the list of users will also be queried, so the query will fall in infinitive loop.  
  <font color = green>solution</font>: We can use @JsonManagedReference and @JsonBackReference on the associated attributes in two classes.  
  @JsonMangedReference: It is the forward part of reference – the one that gets serialized normally. We add this annotation to role in User class so that
  we can get Role object information when we query User.
  @JsonBackReference: It is the back part of reference - it will be omitted from serialization. We add this annotation to the List<User> in Role class so that 
  the list will be ignored and the loop can be broken.
  ~~~java
  @JsonManagedReference
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    @ApiModelProperty
    private Role role;
  ~~~
  ~~~java
  @JsonBackReference
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;
  ~~~
  <font color = red>But </font> when we use these two annotation, the list of users in Role class will be empty, so It can't be serialized in JSON format because 
  the default configuration of spring boot is not allowing the serialization of empty bean. But we can change the configuration:
  ~~~yaml
  #application.yml
  spring:
    jackson:
      serialization:
        fail-on-empty-beans: false
  ~~~
  But I doubt it still have problem when we try to get the list of user for 1 role. The front-end may not be able to get the list because it will not be serialized 
  to JSON. I will try later when time is allowed.