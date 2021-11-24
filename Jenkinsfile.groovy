pipeline {
    agent any
    stages {
      stage('Checkout external proj') {
        steps {
            git branch: 'my_specific_branch',
                credentialsId: 'my_cred_id',
                url: 'ssh://git@test.com/proj/test_proj.git'

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
