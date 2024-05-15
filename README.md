# Javasnipe
![Build Status](https://img.shields.io/teamcity/build/s/Javasnipe_Build?server=https%3A%2F%2Fci.sidpatchy.com&style=flat-square)
 ![GitHub License](https://img.shields.io/github/license/sidpatchy/Javasnipe?style=flat-square&label=License) ![Static Badge](https://img.shields.io/badge/17+-0?style=flat-square&label=Java%20Compatibility) ![Static Badge](https://img.shields.io/badge/6.3.4-0?style=flat-square&label=Snipe-IT%20Version)

A modern and easy-to-use library for interacting with the Snipe-IT API written in Java.

## Features
- **Asynchronous API interactions**: Utilizes `CompletableFuture`s for non-blocking API calls, enabling efficient handling of concurrent operations.
- **Simplified error handling**: Leverages `Optional`s to handle null values gracefully, reducing boilerplate code and simplifying debugging.
- **No new frameworks required**: Built with standard Java classes to minimize the learning curve and integration complexity, ideal for projects looking to avoid dependency on heavy frameworks.
- **Accessibility for all skill levels**: Designed to be straightforward for developers of any skill level.

## Implementation Status
Javasnipe is a work in progress. See below for what is, and is not implemented. 

### Currently Implemented
- Assets (`/hardware`, fully implemented)

### Partially Implemeneted
- Custom fields (able to get/set data for assets, cannot use API endpoint)
- Companies (missing most fields, cannot use API endpoint)
- Locations (missing most fields, cannot use API endpoint)
- People (`/users`, missing most fields, cannot use API endpoint)
- Status Labels (`statuslabels`, missing most fields, cannot use API endpoint)
- Models (missing most fields, cannot use API endpoint)
- Licenses (missing most fields, cannot use API endpoint)
- Categories (missing most fields, cannot use API endpoint)
- Manufacturers (missing most fields, cannot use API endpoint)
- Suppliers (missing most fields, cannot use API endpoint)

### Not Yet Implemented
- Fieldsets (`/fieldsets`)
- Accessories (`/accessories`)
- Consumables (`/consumables`)
- Components (`/components`)
- Asset Maintences (`/maintenacnes`)
- Departments (`/departments`)
- Groups (`/groups`)
- Settings (`/settings/*`)
- Reports (`/reports/activity`)

## Design
Many objects within the Snipe-IT API have different variants: one variant is used when the object is assigned to other objects, and another is used when the object is configured and created.

For example, the Company object assigned to an Asset is different from the Company object used in the configuration.

API wrappers, like Javasnipe, have two options to handle this:
1) Combine both variants into one JavaBean, or
2) Split them into separate JavaBeans.

Javasnipe chose option B because it is more straightforward to work with and develop. The objects assigned to assets, people, etc., are named like Company, while the configuration objects are named like ConfigurableCompany.
