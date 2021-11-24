# devops-test

In this project I have created 3 Dockerfiles, 1 docker compose file and 1 Jenkins file.

The above mentioned files will help to run the MTWA software as containers over docker environment.

1. Dockerfile_appserver : This file is used to install Apche2 as the app server. Here we have used "ubuntu" as the base image.
This will run the command to install required sogftwares and create an image for the app server as mentioned in Gitlab repo : https://gitlab.com/crest1/devops_test.git

2. Dockerfile_webserver: This file is used to create an image for our webserver.
3. Dockerfile_mysql : This will installed required mysql image and will connect to our app server in backgroud.

We have created 1 docker-compose file to run above applications as a container using the images we created in previous step.

Jenkinsfile : It consists of the pipeline script that will help us in achieving the CI/CD for the project.
It will clone the URL, run the docker commands so that our application will run as container as soon as we execute the job.
