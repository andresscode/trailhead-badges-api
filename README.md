# Trailhead Badges API

## Description

REST API created to get the data of the badges in [Trailhead.com](https://trailhead.salesforce.com)
and submit the data of the badges earned by every active user.

The API works with HATEOAS, for in detail information about the API functionality,
please go to this [link.](https://trailheadbadges-api.herokuapp.com)

## Badges

### Get all badges

* **URL:** https://trailheadbadges-api.herokuapp.com/badges
* **Method:** GET

###### Response Sample

    "badges": [
        {
          "type" : "Project",
          "name" : "Build Flexible Apps with Visualforce Pages and Lightning Components",
          "href" : "https://trailhead.salesforce.com/projects/workshop-lightning-programmatic",
          "hours" : 1.83
        },
        {
          "type" : "Project",
          "name" : "Build Reusable Lightning Components",
          "href" : "https://trailhead.salesforce.com/projects/build-reusable-lightning-components",
          "hours" : 1.25
        }
    ]
    
### Find by href

* **URL:** https://trailheadbadges-api.herokuapp.com/badges/search/findByHref{?href}
* **Method:** GET

###### Request Sample

`CURL https://trailheadbadges-api.herokuapp.com/badges/search/findByHref?href=https://trailhead.salesforce.com/projects/workshop-lightning-programmatic`

###### Response Sample

    {
      "type" : "Project",
      "name" : "Build Flexible Apps with Visualforce Pages and Lightning Components",
      "href" : "https://trailhead.salesforce.com/projects/workshop-lightning-programmatic",
      "hours" : 1.83
    }
    
## Users

### Get all users

* **URL:** https://trailheadbadges-api.herokuapp.com/users
* **Method:** GET

###### Response Sample

    "users": [
        {
          "trailheadId" : "ABCDE0123456789",
          "firstName" : "Joe",
          "lastName" : "Doe",
          "company" : "Github",
          "badges" : [
              {
                  "href" : "https://trailhead.salesforce.com/projects/workshop-lightning-programmatic",
                  "earned" : "2018-01-01",
                  "points" : 400
              },
              {
                  "href" : "https://trailhead.salesforce.com/projects/build-reusable-lightning-components",
                  "earned" : "2018-01-01",
                  "points" : 600
              }
          ]
        },
        {
          "trailheadId" : "ABCDE9876543210",
          "firstName" : "Joel",
          "lastName" : "Doel",
          "company" : "Git",
          "badges" : [
              {
                  "href" : "https://trailhead.salesforce.com/projects/workshop-lightning-programmatic",
                  "earned" : "2018-01-22",
                  "points" : 200
              },
              {
                  "href" : "https://trailhead.salesforce.com/projects/build-reusable-lightning-components",
                  "earned" : "2018-01-22",
                  "points" : 550
              }
          ]
        }
    ]
    
### Find by company

* **URL:** https://trailheadbadges-api.herokuapp.com/users/search/findByCompanyContainingIgnoreCase{?company}
* **Method:** GET

###### Request Sample

`CURL https://trailheadbadges-api.herokuapp.com/users/search/findByCompany?company=Github`

###### Response Sample

    {
      "trailheadId" : "ABCDE0123456789",
      "firstName" : "Joe",
      "lastName" : "Doe",
      "company" : "Github",
      "badges" : [
          {
              "href" : "https://trailhead.salesforce.com/projects/workshop-lightning-programmatic",
              "earned" : "2018-01-01",
              "points" : 400
          },
          {
              "href" : "https://trailhead.salesforce.com/projects/build-reusable-lightning-components",
              "earned" : "2018-01-01",
              "points" : 600
          }
      ]
    }
    
### Find by Trailhead Id

* **URL:** https://trailheadbadges-api.herokuapp.com/users/search/findByTrailheadId{?trailheadId}
* **Method:** GET

###### Request Sample

`CURL https://trailheadbadges-api.herokuapp.com/users/search/findByTrailheadId?trailheadId=ABCDE0123456789`

###### Response Sample

    {
      "trailheadId" : "ABCDE0123456789",
      "firstName" : "Joe",
      "lastName" : "Doe",
      "company" : "Github",
      "badges" : [
          {
              "href" : "https://trailhead.salesforce.com/projects/workshop-lightning-programmatic",
              "earned" : "2018-01-01",
              "points" : 400
          },
          {
              "href" : "https://trailhead.salesforce.com/projects/build-reusable-lightning-components",
              "earned" : "2018-01-01",
              "points" : 600
          }
      ]
    }
    
### Save an user

* **URL:** https://trailheadbadges-api.herokuapp.com/users
* **Method:** POST
* **Body Parameters:** (String) trailheadId, (String) firstName, (String) lastName,
(String) company, (List<Badge>) badges

*Note 1: Badge objects are made of (String) href, (String) earned, (Integer) points.*  
*Note 2: The earned field is a String of a Date with format YYYY-MM-DD.*

###### Request Sample

    {
      "trailheadId" : "ABCDE0123456789",
      "firstName" : "Joe",
      "lastName" : "Doe",
      "company" : "Github",
      "badges" : [
          {
              "href" : "https://trailhead.salesforce.com/projects/workshop-lightning-programmatic",
              "earned" : "2018-01-01",
              "points" : 400
          },
          {
              "href" : "https://trailhead.salesforce.com/projects/build-reusable-lightning-components",
              "earned" : "2018-01-01",
              "points" : 600
          }
      ]
    }
    
### Update an user

* **URL:** https://trailheadbadges-api.herokuapp.com/users/{id}
* **Method:** PUT
* **Body Parameters:** (String) trailheadId, (String) firstName, (String) lastName,
(String) company, (List<Badge>) badges

*Note 1: Badge objects are made of (String) href, (String) earned, (Integer) points.*  
*Note 2: The earned field is a String of a Date with format YYYY-MM-DD.*

###### Request Sample

    {
      "trailheadId" : "ABCDE0123456789",
      "firstName" : "Joe",
      "lastName" : "Doe",
      "company" : "Github",
      "badges" : [
          {
              "href" : "https://trailhead.salesforce.com/projects/workshop-lightning-programmatic",
              "earned" : "2018-01-01",
              "points" : 400
          },
          {
              "href" : "https://trailhead.salesforce.com/projects/build-reusable-lightning-components",
              "earned" : "2018-01-01",
              "points" : 600
          }
      ]
    }