### Cloud Demo XXL

- Spring Boot App (start.spring.io)
- Thymeleaf, Devtools, Lombok, Postgesql, JPA
- Ausbaustufe 1: "Nackig"
- Ausbaustufe 2: DB Anbindung dazu (Cloud-Dienst)
- Deployment: HEROKU, Pivotal Cloud Foundry (Openshift, Bluemix, ...)

### HEROKU
+ Web UI: https://id.heroku.com/login
+ CLI downloaden und installieren 
+ Steps
    + Login: heroku login
    + App über Web UI erstellen (cloud-demo-xxl)
    + Deploy: z. B. über GitHub Repo
    + Logs UI oder heroku logs --app cloud-demo-xxl --tail
+ Add Ons
    + z. B. DB (PostgreSql)
    + Config über HEROKU UI
    + Platzhalter in application.config: z. B. ${DATABASE_URL}
+ Sonstiges
    + Fertige Addons, Buildpacks, Buttons
    + Web Dyno Autoscaling
    + Configuration
    + Auto Deploy
    + Pipelines
    + Repos / Container Registry

### Pivotal Cloud Foundry (PCF)
+ Web UI: https://console.run.pivotal.io
+ CLI downloaden und installieren 
+ Steps
    + Login: cf login oder Web UI
    + App über CLI erstellen: cf push cloud-demo-xxl -p target/cloud-demo-0.0.1-SNAPSHOT.jar -b java_buildpack -m 768M
    + logging: cf logs APP-NAME
    + SSH: cf ssh APP-NAME
+ Add Ons
    + z. B. DB (PostgreSql)
    + Config über PCF UI
    + Platzhalter in application.config: z. B. ${DATABASE_URL}
+ Sonstiges
    + Fertige Addons / Services über Marketplace
    + Scaling
    + Configuration

### Misc
+ MongoDB aus Cloud (atlas) >> https://cloud.mongodb.com
+ Weitere Alternativen
    + OpenShift 
    + Weitere Cloud Foundry basierte Plattformen z. B. Bluemix (https://www.cloudfoundry.org/certified-platforms/)


