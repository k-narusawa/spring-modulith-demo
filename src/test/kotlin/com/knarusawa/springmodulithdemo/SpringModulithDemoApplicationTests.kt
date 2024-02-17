package com.knarusawa.springmodulithdemo

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

@SpringBootTest
class SpringModulithDemoApplicationTests {

	@Test
	fun contextLoads() {
	}

	@Test
	fun writeDocumentationSnippets(){
		val modules =
				ApplicationModules.of(SpringModulithDemoApplication::class.java).verify()

		Documenter(modules).writeModulesAsPlantUml().writeIndividualModulesAsPlantUml()
	}

}
