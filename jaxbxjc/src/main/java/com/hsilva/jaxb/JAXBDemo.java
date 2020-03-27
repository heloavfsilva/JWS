package com.hsilva.jaxb;

import java.io.StringReader;
import java.io.StringWriter;
//import java.rmi.UnmarshalException;

import javax.xml.bind.*;

import com.hsilva.patient.Patient;
public class JAXBDemo {

	public static void main(String[] args) {

		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();
			
			Patient patient = new Patient();
			patient.setId(12);
			patient.setName("Heloa");
			
			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);
			
			System.out.println(writer.toString());
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
//			StringReader reader = new StringReader();
					
			Patient patientResult = (Patient) (unmarshaller.unmarshal(new StringReader(writer.toString())));
			System.out.println(patientResult.getName());
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
