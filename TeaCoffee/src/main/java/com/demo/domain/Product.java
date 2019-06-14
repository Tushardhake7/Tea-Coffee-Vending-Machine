package com.demo.domain;

public class Product {
	
		private String productName;
		private Integer productQuantity;
		private Integer productPrice;
		
		public Product() { }
		
		public Product(String productName, Integer productQuantity, Integer productPrice) {
			super();
			this.productName = productName;
			this.productQuantity = productQuantity;
			this.productPrice = productPrice;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public Integer getProductQuantity() {
			return productQuantity;
		}

		public void setProductQuantity(Integer productQuantity) {
			this.productQuantity = productQuantity;
		}

		public Integer getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(Integer productPrice) {
			this.productPrice = productPrice;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((productName == null) ? 0 : productName.hashCode());
			result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
			result = prime * result + ((productQuantity == null) ? 0 : productQuantity.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			if (productName == null) {
				if (other.productName != null)
					return false;
			} else if (!productName.equals(other.productName))
				return false;
			if (productPrice == null) {
				if (other.productPrice != null)
					return false;
			} else if (!productPrice.equals(other.productPrice))
				return false;
			if (productQuantity == null) {
				if (other.productQuantity != null)
					return false;
			} else if (!productQuantity.equals(other.productQuantity))
				return false;
			return true;
		}
		
		
	}
