# NYC Taxi Traffic Analysis with Apache Spark

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Scala](https://img.shields.io/badge/Scala-2.12+-red.svg)](https://www.scala-lang.org/)
[![Apache Spark](https://img.shields.io/badge/Apache%20Spark-3.x-orange.svg)](https://spark.apache.org/)

A Big Data pipeline built with Apache Spark and Scala for analyzing New York City taxi traffic patterns. This project implements a complete data engineering workflow from ingestion through cleaning, transformation, and analysis to extract spatio-temporal trends, payment behaviors, and optimization opportunities for ride-sharing.

## 🎯 Project Overview

This project constructs a comprehensive Big Data pipeline to:
- **Ingest** large-scale NYC taxi trip data
- **Clean** and validate data quality
- **Transform** raw data into analytical datasets
- **Analyze** spatio-temporal patterns, payment methods, and operational metrics
- **Identify** optimization opportunities for ride-sharing and route efficiency

## 🏗️ Architecture

The pipeline follows a standard ETL (Extract, Transform, Load) architecture:

```
Raw Data → Data Ingestion → Data Cleaning → Data Transformation → Analysis → Insights
```

### Key Components:
1. **Data Ingestion**: Loading NYC TLC Trip Record Data
2. **Data Cleaning**: Removing invalid records, handling missing values, outlier detection
3. **Data Transformation**: Feature engineering, aggregations, temporal/spatial analysis
4. **Analysis**: Statistical analysis, pattern recognition, trend identification
5. **Optimization**: Ride-sharing potential, route optimization recommendations

## 📊 Dataset

This project uses the **NYC Taxi & Limousine Commission (TLC) Trip Record Data**, which includes:
- Yellow taxi trips
- Green taxi trips
- Pickup and dropoff locations
- Trip distances and durations
- Fare amounts and payment types
- Passenger counts
- Timestamps for temporal analysis

**Data Source**: [NYC TLC Trip Record Data](https://www.nyc.gov/site/tlc/about/tlc-trip-record-data.page)

## 🛠️ Technologies

- **Apache Spark 3.x**: Distributed data processing
- **Scala 2.12+**: Primary programming language
- **SBT**: Build tool
- **Parquet**: Optimized columnar storage format

## 📋 Prerequisites

Before running this project, ensure you have:

- Java 8 or Java 11
- Scala 2.12 or higher
- Apache Spark 3.x
- SBT (Simple Build Tool)
- Sufficient storage for NYC taxi datasets (~several GB)

## 🚀 Getting Started

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/krichenyoussef/Analyse_du_trafic_des_taxis_New_York_City_Spark.git
   cd Analyse_du_trafic_des_taxis_New_York_City_Spark
   ```

2. **Navigate to the project directory**
   ```bash
   cd nyc-taxi-spark
   ```

3. **Build the project**
   ```bash
   sbt compile
   ```

### Running the Pipeline

1. **Download NYC Taxi Data**
   Download the desired month(s) of data from the [NYC TLC website](https://www.nyc.gov/site/tlc/about/tlc-trip-record-data.page)

2. **Configure data paths**
   Update the data paths in your configuration files to point to your downloaded datasets

3. **Run the analysis**
   ```bash
   sbt run
   ```

   Or package and submit to Spark:
   ```bash
   sbt package
   spark-submit --class com.yourpackage.MainClass \
                --master local[*] \
                target/scala-2.12/nyc-taxi-spark_2.12-0.1.0.jar
   ```

## 📈 Analysis Capabilities

### Spatio-Temporal Analysis
- **Peak hours identification**: Busiest times of day for taxi demand
- **Geographic hotspots**: High-demand pickup and dropoff locations
- **Seasonal patterns**: Variations across months and seasons
- **Weekday vs. weekend trends**: Behavioral differences

### Payment Analysis
- **Payment method distribution**: Cash vs. credit card usage
- **Tipping patterns**: Average tips by payment type and time
- **Fare analysis**: Average fares by distance and location

### Operational Optimization
- **Trip duration analysis**: Average durations by route and time
- **Distance efficiency**: Optimal routes and detour detection
- **Ride-sharing potential**: Identifying opportunities for shared rides
- **Fleet optimization**: Recommendations for taxi positioning

## 📁 Project Structure

```
Analyse_du_trafic_des_taxis_New_York_City_Spark/
├── nyc-taxi-spark/
│   ├── src/
│   │   ├── main/
│   │   │   └── scala/
│   │   │       ├── DataIngestion.scala
│   │   │       ├── DataCleaning.scala
│   │   │       ├── DataTransformation.scala
│   │   │       ├── Analysis.scala
│   │   │       └── Main.scala
│   │   └── test/
│   │       └── scala/
│   ├── build.sbt
│   └── project/
├── data/                      # Data directory (not tracked)
├── results/                   # Analysis outputs
├── .gitignore
├── LICENSE
└── README.md
```

## 🔍 Key Features

- **Distributed Processing**: Leverage Spark's distributed computing for large-scale data
- **Data Quality**: Comprehensive cleaning and validation steps
- **Scalable**: Designed to handle millions of trip records
- **Modular**: Separated concerns for ingestion, cleaning, transformation, and analysis
- **Reproducible**: Clear pipeline steps and configuration

## 📊 Example Insights

The analysis can reveal insights such as:
- Manhattan has the highest concentration of taxi pickups during morning rush hours (7-9 AM)
- Credit card payments correlate with higher tip percentages
- Potential for 15-20% ride-sharing matches during peak hours
- Average trip duration increases by 30% during rain events
- Weekend nights show different demand patterns compared to weekdays

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Youssef Krichen**
- GitHub: [@krichenyoussef](https://github.com/krichenyoussef)

## 🙏 Acknowledgments

- NYC Taxi & Limousine Commission for providing the open dataset
- Apache Spark community for the excellent distributed computing framework
- Contributors and maintainers of the Scala ecosystem

## 📚 References

- [NYC TLC Trip Record Data](https://www.nyc.gov/site/tlc/about/tlc-trip-record-data.page)
- [Apache Spark Documentation](https://spark.apache.org/docs/latest/)
- [Scala Documentation](https://docs.scala-lang.org/)

## 🔗 Related Projects

Looking for similar analyses? Check out these related projects:
- [PySpark NYC Taxi Analysis](https://github.com/Alpha-1787/PySpark-NYC-Taxi-Trips-Analysis)
- [NYC Taxi Databricks](https://github.com/12rootx/NYC-Taxi-Big-Data-Processing-with-Databricks-Spark)

---

⭐ If you found this project useful, please consider giving it a star!
