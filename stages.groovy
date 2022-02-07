
        stage('SonarQube analysis') {
            steps {
                script {
            scannerHome = tool 'sonarqube-scanner-4.6.2'
        }
            withSonarQubeEnv('sonarqube') {
            sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=devops -Dsonar.sources=. "
        }
      }
    }

        stage('SonarQube analysis') {
            steps {
                script {
            scannerHome = tool 'sonarqube-scanner-4.6.2'
        }
            withSonarQubeEnv('sonarqube') {
            sh "dotnet ${scannerHome}/SonarScanner.MSBuild.dll begin /k:\"devops2\""
            sh "dotnet build"
            sh "dotnet ${scannerHome}/SonarScanner.MSBuild.dll end"
        }
      }
    }

            stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }