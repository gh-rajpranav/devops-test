pipeline {
    agent any
    stages {
      stage('Checkout external proj') {
        steps {
            git credentialsId: '96dff699-adf1-4ef7-992f-543278a09c92', url: 'https://github.com/gh-rajpranav/devops-test.git'
            sh "ls -lat"
           }
         }

        stage('Build the image from docker file') {
            steps {
               sh '''         
                 echo "Building images"
                 docker build -f Dockerfile_appserver rpdockerregistry/webapp .
                 docker build -f Dockerfile_webserver rpdockerregistry/app .
                 docker build -f Dockerfile_mysql rpdockerregistry/sql .

                 
                 '''
            }
        }

        stage('Run the docker compose file') {
            steps {
               sh '''  
                  echo "Run the docker compose yaml file"       
                  docker-compose -f docker-compose.yaml up
                 
                 '''
            }
        }
    }
}
