pipeline{
    agent any
    tools {
		maven 'maven'
	}
    environment
    {
        VERSION="$BUILD_NUMBER"
        PROJECT='flight-search'
        IMAGE= "$PROJECT:latest"
        ECRURL='https://196737838717.dkr.ecr.ap-south-1.amazonaws.com/flight-search'
        ECRCRED='ecr:ap-south-1:awscredentials'

    }

    stages {
       
        stage ('Compile Stage'){
			steps{
				sh 'mvn clean compile'	
			}	
		}

		stage ('Sonarqube deployment Stage'){
			steps{
				sh 'mvn sonar:sonar -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=42c2f6e3649c1a7266c68c8a7ba32f012e27617b -Dsonar.organization=default-organization'	
			}	
		}

        stage ('Build executable jar'){
			steps{
				sh 'mvn install'	
			}	
		}
      
        stage('Image Build'){
            steps{
                script{
                    docker.build('$IMAGE')
                }
            }
        }
        stage('Push Image'){
            steps{
                script{
                    docker.withRegistry(ECRURL, ECRCRED){
                        docker.image(IMAGE).push()
                    }
                }
            }  
        }
    }

    post{
        always{
            sh "docker rmi $IMAGE | true"
        }
    }
}