package Interview;

//IBM Watson OA

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class filter {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			PassageFilter passageFilter = new PassageFilter();
			passageFilter.filter(s);
			System.out.println(passageFilter.getFormattedOutput());
		}
	}

	/**
	 * The class PassageFilter provides methods to filter passages from a raw
	 * input text and stores a list of filtered passages.
	 * 
	 * @author John
	 *
	 */
	private static class PassageFilter {

		private final List<String> outputPassages;

		public PassageFilter() {
			this.outputPassages = new ArrayList<String>();
		}

		public void filter(String rawInput) {
			String[] passages = rawInput.split("\\|");

			for (String thisPass : passages) {
				String thisNormed = normalize(thisPass);
				boolean filt = false;
				for (int i = 0; i < outputPassages.size(); i++) {
					String existingNormed = normalize(outputPassages.get(i));

					if(existingNormed.contains(thisNormed)){
						filt=true;
						break;
					}
				}
				if(!filt){
					outputPassages.add(thisPass);
				}
			}
			filterfinal();
		}
		
		private final List<String> filnaloutputPassages = new ArrayList<String>();
		
		public void filterfinal(){
			for (int i=0; i < outputPassages.size(); i++) {
				boolean isvalid=true;
				for(int j=0; j<outputPassages.size();j++){
					if(i!=j && outputPassages.get(j).contains(outputPassages.get(i))){
							isvalid=false;
							break;
						}
				}
				if(isvalid){
					filnaloutputPassages.add(outputPassages.get(i));
				}
			}
		}

		private String normalize(String passage) {
			return passage.trim().replaceAll("\\s+", " ").replace(".", "").replace(';', ',').toLowerCase().trim();
		}

		public String getFormattedOutput() {
			boolean first = true;
			StringBuilder sb = new StringBuilder();
			for (String op : filnaloutputPassages) {
				if (!first)
					sb.append('|');
				first = false;
				sb.append(op);
			}
			return sb.toString();
		}

	}

}