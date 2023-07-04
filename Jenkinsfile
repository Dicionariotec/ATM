node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withSonarQubeEnv() {
      sh "./gradlew sonar"
    }
  }

  stage('JUnit tests') {
    withGradle {
      sh './gradlew test --scan'
    }
  }
}