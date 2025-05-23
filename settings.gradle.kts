rootProject.name = "ktChat-Server"

val localProperties = java.util.Properties().apply {
    file("local.properties").takeIf { it.exists() }?.let {
        load(java.io.FileInputStream(it))
    }
}

val demoEnable = localProperties.getProperty("demo.enable")?.equals("true", true) == true

fun includeDemos(demoDirName: String) {
    if (demoEnable) {
        include(":$demoDirName")
        project(":$demoDirName").also {
            it.projectDir = file("./demos/$demoDirName")
            it.name = "demo-$demoDirName"
        }
    }
}